package appcr.adminpc.chatbotapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.UserViewHolder>{

    List<Message> messageList;
    public ChatAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mssg_item, null);
        UserViewHolder userViewHolder = new UserViewHolder(chatView);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Message message = messageList.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        if(message.getSendBy().equals(Message.SEND)){
            holder.leftChatView.setVisibility(View.GONE);
            holder.rightChatView.setVisibility(View.VISIBLE);
            holder.botTimeView.setVisibility(View.GONE);
            holder.userTimeView.setVisibility(View.VISIBLE);
            holder.userTimeView.setText(currentTime);
            holder.rightTextView.setText(message.getMessage());
        }else {
            holder.leftChatView.setVisibility(View.VISIBLE);
            holder.rightChatView.setVisibility(View.GONE);
            holder.userTimeView.setVisibility(View.GONE);
            holder.botTimeView.setVisibility(View.VISIBLE);
            holder.botTimeView.setText(currentTime);
            holder.leftTextView.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftChatView, rightChatView;
        TextView leftTextView, rightTextView;
        TextView botTimeView, userTimeView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            leftChatView = itemView.findViewById(R.id.bot_view);
            rightChatView = itemView.findViewById(R.id.user_view);

            leftTextView = itemView.findViewById(R.id.bot_text_view);
            rightTextView = itemView.findViewById(R.id.user_text_view);

            botTimeView = itemView.findViewById(R.id.bot_time_view);
            userTimeView = itemView.findViewById(R.id.user_time_view);
        }
    }
}
