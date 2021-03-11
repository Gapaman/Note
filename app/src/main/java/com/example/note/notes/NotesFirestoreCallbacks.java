package com.example.note.notes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.note.model.NoteModel;

import java.util.List;
public interface NotesFirestoreCallbacks {
    void onSuccessNotes(@NonNull List<NoteModel> items);
    void onErrorNotes(@Nullable String message);
}