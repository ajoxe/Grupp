package com.example.c4q.capstone.userinterface.events.createevent;


import android.view.View;

import com.example.c4q.capstone.database.publicuserdata.PublicUserDetails;
import com.example.c4q.capstone.userinterface.user.userprofilefragments.userprofileviews.ContactListViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by melg on 3/20/18.
 */

public class InviteListAdapter extends FirebaseRecyclerAdapter<PublicUserDetails, ContactListViewHolder> {
    View.OnClickListener onClickListener;

    public InviteListAdapter(Class<PublicUserDetails> modelClass, int modelLayout, Class<ContactListViewHolder> viewHolderClass, Query ref, View.OnClickListener onClickListener) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.onClickListener = onClickListener;
    }

    @Override
    protected void populateViewHolder(ContactListViewHolder viewHolder, PublicUserDetails model, int position) {
        String first = model.getFirst_name();
        String last = model.getLast_name();
        String email = model.getEmail();
        String url = model.getIcon_url();

        viewHolder.setUserIcon(url);
        viewHolder.setName(first,last);
        viewHolder.setEmail(email);
        viewHolder.itemView.setTag(model.getUid());
        viewHolder.itemView.setOnClickListener(onClickListener);
    }

    /*@Override
    protected void populateViewHolder(ContactListViewHolder viewHolder, UserContacts model, int position) {
        *//*String email = model.getContacts().get(position).getEmail();
        String first = model.getContacts().get(position).getFirst_name();
        String last = model.getContacts().get(position).getLast_name();
        String icon = model.getContacts().get(position).getIcon_url();

        viewHolder.setEmail(email);
        viewHolder.setName(first, last);
        viewHolder.setUserIcon(icon);
    }*/
}
