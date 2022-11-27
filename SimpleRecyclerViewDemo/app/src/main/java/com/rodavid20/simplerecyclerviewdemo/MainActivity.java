package com.rodavid20.simplerecyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvUserList = findViewById(R.id.rvUserList);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Query query = db.collection("users").orderBy("name", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<UserModel>
                options = FirestoreRecyclerOptions.Builder<UserModel>()
                .setQuery(query, UserModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<UserModel, UserViewHolder>(options) {
            @NonNull
            @Override
            public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            protected void onBindViewHolder(@NotNull UserViewHolder holder, int position, @NotNull UserModel model) {
                holder.setData(model.getName(), model.getPhone());
            }
        };
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public UserViewHolder(@NotNull View itemview) {
            super(itemview);
            view = itemview;
        }

        public void setData(String Title, String Subtitle) {
            TextView tvUserRowTitle = view.findViewById(R.id.tv);

        }
    }
}