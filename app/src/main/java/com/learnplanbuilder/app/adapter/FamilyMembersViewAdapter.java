package com.learnplanbuilder.app.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learnplanbuilder.app.R;
import com.learnplanbuilder.app.room.FamilyMemberModel;

import java.util.List;

public class FamilyMembersViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Activity context;
    private List<FamilyMemberModel> familyMembersList;

    public FamilyMembersViewAdapter(Activity context, List<FamilyMemberModel> userArrayList) {
        this.context = context;
        this.familyMembersList = userArrayList;
    }

    public FamilyMembersViewAdapter(Activity context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.family_list_row, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FamilyMemberModel familyMember = familyMembersList.get(position);
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;

        viewHolder.nameTV.setText(familyMember.getFirstName() + " " + familyMember.getLastName());
        viewHolder.relationTV.setText(familyMember.getRelationWHOF());
    }

    @Override
    public int getItemCount() {
        return familyMembersList.size();
    }

    public void setData(List<FamilyMemberModel> familyMembers) {
        familyMembersList = familyMembers;
        notifyDataSetChanged();
    }

    static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView_icon;
        TextView nameTV;
        TextView relationTV;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView_icon = itemView.findViewById(R.id.user_IMV);
            nameTV = itemView.findViewById(R.id.name_TV);
            relationTV = itemView.findViewById(R.id.relation_TV);
        }
    }
}
