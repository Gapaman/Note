package com.example.note.notedetails;


import androidx.annotation.NonNull;


public interface NoteRepository {

    void setNote(
            @NonNull String id,
            @NonNull String title,
            @NonNull String description
    );

    void onDeleteClicked(@NonNull String id);
}