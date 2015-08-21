package messagingapp.mastermind.com.messagingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

/**
 * Created by Dip on 8/20/2015.
 */
public class MessageAdapter extends ArrayAdapter<ParseObject> {

   protected Context mContext;
    protected List<ParseObject> mMessages;


    public MessageAdapter(Context context,List<ParseObject> messages){

        super(context,R.layout.message_item,messages);


        mContext = context;
        mMessages = messages;



    }
     //*****************************************************
    //To use a customList we need to override getView !
    //*****************************************************
    @Override
    public View getView(int position,View convertView,ViewGroup parent){

        ViewHolder holder;

        if(convertView==null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.message_item, null);

            holder = new ViewHolder();

            holder.iconImageView = (ImageView) convertView.findViewById(R.id.messageIcon);
            holder.nameLabel = (TextView) convertView.findViewById(R.id.senderLabel);
            convertView.setTag(holder);
        }
        else
        {
            //getTag() reutrns the ViewHolder that was already created

            holder = (ViewHolder)convertView.getTag();

        }
        ParseObject message = mMessages.get(position);

        if(message.getString(ParseConstants.KEY_FILE_TYPE).equals(ParseConstants.TYPE_IMAGE))
        {
            holder.iconImageView.setImageResource(R.drawable.ic_action_picture);
        }
        else
        {
            holder.iconImageView.setImageResource(R.drawable.ic_action_play_over_video);
        }


        holder.nameLabel.setText(message.getString(ParseConstants.KEY_SENDER_NAME));



        return convertView;
    }


    //Anonymous Class


    private static class ViewHolder{

     ImageView iconImageView;
     TextView nameLabel;


    }



}
