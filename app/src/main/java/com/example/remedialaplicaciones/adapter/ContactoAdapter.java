package com.example.remedialaplicaciones.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remedialaplicaciones.Calling;
import com.example.remedialaplicaciones.R;
import com.example.remedialaplicaciones.SpecificInfo;
import com.example.remedialaplicaciones.model.Contacto;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoHolder> {
    private List<Contacto> listcon;

    public ContactoAdapter(List<Contacto> listcon) {
        this.listcon = listcon;
    }

    @NonNull
    @Override
    public ContactoAdapter.ContactoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lyf = LayoutInflater.from(parent.getContext());
        View v = lyf.inflate(R.layout.activity_box_items,parent,false);
        return new ContactoHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoAdapter.ContactoHolder holder, int position) {
        Contacto co = listcon.get(position);
        holder.setData(co);
    }

    @Override
    public int getItemCount() {
        return listcon.size();
    }

    public class ContactoHolder extends RecyclerView.ViewHolder {
        TextView name;
        Button button;

        public ContactoHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nombre);
            button = itemView.findViewById(R.id.ir);
        }

        public void setData(Contacto co) {
            name.setText(co.getName());
            if ("Leo".equals(co.getName())){
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent call = new Intent(itemView.getContext(), Calling.class);
                        call.putExtra("number","8711231234");
                        itemView.getContext().startActivity(call);
                    }
                });
            }
            else if ("Sam".equals(co.getName())){
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String numberr = "8711231234";
                        Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+numberr));
                    }
                });
            }
            else if ("Jade".equals(co.getName())){
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent internet = new Intent(Intent.ACTION_VIEW,Uri.parse("https://google.com"));
                        itemView.getContext().startActivity(internet);
                    }
                });
            }
            else if ("Marcus".equals(co.getName())){
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent personal = new Intent(itemView.getContext(), SpecificInfo.class);
                        personal.putExtra("name",co.getName());
                        personal.putExtra("age",co.getAge());
                        personal.putExtra("gender",co.getGender());
                        personal.putExtra("hobby",co.getHobby());
                        itemView.getContext().startActivity(personal);
                    }
                });
            }
            else if ("Abby".equals(co.getName())){
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent geo = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:37.7,0"));
                        itemView.getContext().startActivity(geo);
                    }
                });
            }
        }
    }
}
