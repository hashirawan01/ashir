package com.example.ashir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class adapter1 extends RecyclerView.Adapter<adapter1.viewHolder> {
    private List<Model_class> classList;
    private Context context;

    public adapter1(List<Model_class> classList, Context context) {
        this.classList = classList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        int resource = classList.get(position).getImagebox();
        String title = classList.get(position).getTitle();
        String body = classList.get(position).getBody();
        holder.setdata(resource, title, body);
    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;
        private TextView body;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview1);
            title = itemView.findViewById(R.id.ttle);
            body = itemView.findViewById(R.id.body);
            classList.remove(0);

        }

        private void setdata(int resource, String titletext, String textbody) {
            imageView.setImageResource(resource);
            title.setText(titletext);
            body.setText(textbody);
        }
    }
}
