package com.example.note.notes;

import androidx.annotation.NonNull;

import com.example.note.model.NoteModel;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class NotesRepositoryImpl implements NotesRepository {

    private final FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private final NotesFirestoreCallbacks callbacks;

    public NotesRepositoryImpl(NotesFirestoreCallbacks callbacks) {
        this.callbacks = callbacks;
    }

    @Override
    public void onDeleteClicked(@NonNull String id) {
        firebaseFirestore
                .collection(Constants.ACTION_LOAD_IMAGE)
                .document(id)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        requestNotes();
                    }
                });
    }

    @Override
    public void requestNotes() {
        firebaseFirestore
                .collection(Constants.ACTION_LOAD_IMAGE)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.getResult() != null) {
                            List<NoteModel> items = task.getResult().toObjects(NoteModel.class);
                            callbacks.onSuccessNotes(items);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        callbacks.onErrorNotes(e.getMessage());
                    }
                });
    }
}