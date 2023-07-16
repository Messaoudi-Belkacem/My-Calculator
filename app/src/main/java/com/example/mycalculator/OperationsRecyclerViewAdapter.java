package com.example.mycalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OperationsRecyclerViewAdapter extends RecyclerView.Adapter<OperationsRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Operation> operationArrayList = new ArrayList<>();
    public OperationsRecyclerViewAdapter() {

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.operations_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.operationsTextView.setText(operationArrayList.get(position).getOperation());
        holder.resultTextView.setText(operationArrayList.get(position).getResult());
    }

    @Override
    public int getItemCount() {
        return operationArrayList.size();
    }

    public void setOperationArrayList(ArrayList<Operation> operationArrayList) {
        this.operationArrayList = operationArrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView operationsTextView,resultTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            operationsTextView = itemView.findViewById(R.id.operationTextView);
            resultTextView = itemView.findViewById(R.id.resultTextView);
        }
    }
}
