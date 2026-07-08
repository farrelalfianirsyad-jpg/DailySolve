package com.example.dailysolve.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.*;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dailysolve.R;
import com.example.dailysolve.activities.DetailActivity;
import com.example.dailysolve.model.Report;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.Holder> {

    Context context;
    List<Report> list;

    public ReportAdapter(Context context, List<Report> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_report, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder h, int position) {

        Report r = list.get(position);

        h.title.setText(r.getTitle());
        h.desc.setText(r.getDescription());


        h.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, DetailActivity.class);

            intent.putExtra("id", r.getId());
            intent.putExtra("title", r.getTitle());
            intent.putExtra("desc", r.getDescription());
            intent.putExtra("category", r.getCategory());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView title, desc;

        public Holder(View v) {
            super(v);
            title = v.findViewById(R.id.tvTitle);
            desc = v.findViewById(R.id.tvDesc);
        }
    }
}