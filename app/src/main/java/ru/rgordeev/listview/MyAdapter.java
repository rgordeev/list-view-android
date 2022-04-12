package ru.rgordeev.listview;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context context;
    private final List<Person> persons;

    public MyAdapter(Context context, List<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("CREATE HOLDER", "create holder");
        View viewItem = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i("BIND DATA", "bind date" + position);
        Person person = persons.get(position);
        holder.setData(person);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setData(Person person) {
            TextView name = itemView.findViewById(R.id.name);
            name.setText(person.getName());

            TextView phone = itemView.findViewById(R.id.phone);
            phone.setText(person.getPhone());
        }
    }
}
