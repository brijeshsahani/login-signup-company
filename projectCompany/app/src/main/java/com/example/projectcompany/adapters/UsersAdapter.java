package com.example.projectcompany.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectcompany.R;
import com.example.projectcompany.models.Alluser;
import com.example.projectcompany.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private Context mCtx;
    private ArrayList<Alluser> userList;
    private ClickHandler clickHandler;

    public UsersAdapter(Context mCtx, ArrayList<Alluser> userList,ClickHandler clickHandler) {
        this.mCtx = mCtx;
        this.userList = userList;
        this.clickHandler = clickHandler;
    }

    @NonNull
    @Override
    public UsersAdapter.UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_users,parent,false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UsersViewHolder holder, int position) {

        holder.clickHandler = this.clickHandler;

        Alluser user=userList.get(position);
      //  holder.textviewsid.setText(""+user.getId());
        holder.textviewfirstname.setText(user.getFirstname());
        holder.textviewlastname.setText(user.getLastname());
        holder.textviewemailid.setText(user.getEmailid());
//        holder.textviewaddress.setText(user.getAddress());
//        holder.textviewgender.setText(user.getGender());
//        holder.textviewbirthdate.setText(user.getBirthdate());
//       holder.textviewmobileno.setText(""+user.getMobileno());
//        holder.textViewpassword.setText(user.getPassword());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public interface ClickHandler {
        void onButtonClick(final int position);
    }

    class UsersViewHolder extends RecyclerView.ViewHolder{
        private ClickHandler clickHandler;
        TextView textviewsid,textviewfirstname,textviewlastname,textviewemailid,textviewaddress,textviewgender,textviewbirthdate,textviewmobileno,textViewpassword;
        RelativeLayout rlclick;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);

           // textviewsid=itemView.findViewById(R.id.textviewid);
            textviewfirstname=itemView.findViewById(R.id.textviewfname);
            textviewlastname=itemView.findViewById(R.id.textviewlname);
            textviewemailid=itemView.findViewById(R.id.textviewemailid);
//            textviewaddress=itemView.findViewById(R.id.textviewaddress);
//            textviewgender=itemView.findViewById(R.id.textviewgender);
//            textviewbirthdate=itemView.findViewById(R.id.textviewbod);
//            textviewmobileno=itemView.findViewById(R.id.textviewmobileno);
//            textViewpassword=itemView.findViewById(R.id.textviewpassword);

            rlclick = itemView.findViewById(R.id.rlclick);
            rlclick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if(clickHandler != null){
                            clickHandler.onButtonClick(getAdapterPosition());
                        }
                }
            });
        }
    }
}
