package com.xmcu.mobile.activity;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.xmcu.mobile.R;
import com.xmcu.mobile.base.Constants;
import com.xmcu.mobile.db.DatabaseHelper;
import com.xmcu.mobile.entity.ChatFriend;
import com.xmcu.mobile.entity.User;
import com.xmcu.mobile.util.AppUtility;
import com.xmcu.mobile.util.Base64;
import com.xmcu.mobile.util.DateHelper;
import com.xmcu.mobile.util.ExpressionUtil;
import com.xmcu.mobile.util.PrefUtility;
import com.xmcu.mobile.CampusApplication;
/**
 * 
 * #(c) ruanyun PocketCampus <br/>
 * 
 * 版本说明: $id:$ <br/>
 * 
 * 功能说明: 消息列表界面
 * 
 * <br/>
 * 创建说明: 2013-12-9 下午12:51:50 zhuliang 创建文件<br/>
 * 
 * 修改历史:<br/>
 * 
 */
public class ChatFriendActivity extends Activity implements OnItemClickListener {
	private String TAG= "ChatFriendActivity";
	private ListView mList;
	private MessageAdapter mAdapter;
	static Button menu;
	static LinearLayout layout_menu;
	private TextView title,content_none;
	private DatabaseHelper database;
	private Dao<ChatFriend, Integer> chatFriendDao;
	private String ACTION_NAME = "ChatInteract";
	private User user;
	private List<ChatFriend> chatFriendList;
	public static boolean isruning = false;
	AQuery aq;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "----------------onCreate-----------------------");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		registerBoradcastReceiver();
		initTitle();
		initContent();
	}

	private void initTitle() {
		
		
		title = (TextView) findViewById(R.id.tv_title);
		title.setVisibility(View.VISIBLE);
		title.setText(R.string.message);
		LinearLayout relogin = (LinearLayout) findViewById(R.id.layout_back);
		relogin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((CampusApplication)getApplicationContext()).reLogin();
			}
			
		});
		
		user=((CampusApplication)getApplicationContext()).getLoginUserObj();

		
	}

	@Override
	protected void onStart() {
		super.onStart();
		isruning = true;
	}

	@Override
	protected void onStop() {
		super.onStop();
		isruning = false;
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		initContent();
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.cancel(1);
	}

	private void initContent() {
		mList = (ListView) findViewById(R.id.message_list);
		content_none = (TextView)findViewById(R.id.chat_msg_none);
		try {
			chatFriendDao = getHelper().getChatFriendDao();
			String hostid = PrefUtility.get(Constants.PREF_CHECK_HOSTID, "");
			chatFriendList=chatFriendDao.queryBuilder().orderBy("lastTime", false).where().eq("hostid", hostid).query();
			if (chatFriendList != null && chatFriendList.size() > 0) {
				content_none.setVisibility(View.GONE);
			}else{
				content_none.setVisibility(View.VISIBLE);
			}
			if(mAdapter==null)
			{
				mAdapter = new MessageAdapter(ChatFriendActivity.this,
					chatFriendList);
				mList.setAdapter(mAdapter);
				mList.setOnItemClickListener(this);
			}
			else
			{
				mAdapter.list=chatFriendList;
				mAdapter.notifyDataSetChanged();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * #(c) ruanyun PocketCampus <br/>
	 * 
	 * 版本说明: $id:$ <br/>
	 * 
	 * 功能说明: 消息list适配器
	 * 
	 * <br/>
	 * 创建说明: 2013-12-9 下午1:10:31 zhuliang 创建文件<br/>
	 * 
	 * 修改历史:<br/>
	 * 
	 */
	class MessageAdapter extends BaseAdapter {
		private List<ChatFriend> list = new ArrayList<ChatFriend>();
		private Context context;
		private LayoutInflater mInflater;

		public MessageAdapter(Context context, List<ChatFriend> list) {
			this.context = context;
			this.list = list;
			this.mInflater = LayoutInflater.from(this.context);
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.view_message_list, null);
				holder.photo = (ImageView) convertView.findViewById(R.id.photo);
				holder.name = (TextView) convertView.findViewById(R.id.name);
				holder.content = (TextView) convertView
						.findViewById(R.id.content);
				holder.time = (TextView) convertView.findViewById(R.id.time);
				holder.unreadCnt = (TextView) convertView
						.findViewById(R.id.unreadCnt);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			final ChatFriend chatFriend = (ChatFriend) getItem(position);
			holder.name.setText(chatFriend.getToname());
			String lasttime = DateHelper.getDateString(
					chatFriend.getLastTime(), "yyyy-MM-dd");
			String nowdate = DateHelper.getDateString(new Date(), "yyyy-MM-dd");
			if (nowdate.equals(lasttime)) {
				holder.time.setText(DateHelper.getDateString(
						chatFriend.getLastTime(), "HH:mm"));
			} else {
				holder.time.setText(DateHelper.getDateString(
						chatFriend.getLastTime(), "MM-dd"));
			}
			//显示带表情的字符串
			SpannableString spannableString = ExpressionUtil
					.getExpressionString(ChatFriendActivity.this, chatFriend
							.getLastContent().toString());
			holder.content.setText("");
			holder.content.append(spannableString);
			if ("img".equals(chatFriend.getType())) {
				holder.content.setText("["+getString(R.string.image)+"]");
			}

			if (chatFriend.getUnreadCnt() == 0) {
				holder.unreadCnt.setVisibility(View.INVISIBLE);
			}
			else
				holder.unreadCnt.setVisibility(View.VISIBLE);
			aq = new AQuery(convertView);
			holder.unreadCnt.setText(String.valueOf(chatFriend.getUnreadCnt()));
			if(chatFriend.getUserImage().equals("group"))
				holder.photo.setImageResource(R.drawable.group);
			else
			{
				/*
				Bitmap bitmap = aq.getCachedImage(chatFriend
						.getUserImage());
				if (bitmap != null) {
					aq.id(holder.photo).image(
							ImageUtility.getRoundedCornerBitmap(bitmap, 10));
				}
				else
				*/
				aq.id(holder.photo).image(chatFriend.getUserImage(),true,true,0,R.drawable.ic_launcher);
			}
			/*
			if(chatFriend.getMsgType().equals("群消息")){
				holder.photo.setImageResource(R.drawable.contacts_group);
			}*/
			holder.photo.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					
					
					String toid;
					if(chatFriend.getToid().split(",").length>1)
						toid=chatFriend.getToid().split(",")[0];
					else
						toid=chatFriend.getToid();
				
					
						Intent intent = new Intent(ChatFriendActivity.this,
								ShowPersonInfo.class);
						intent.putExtra("studentId", toid);
						intent.putExtra("userImage",chatFriend.getUserImage());
						startActivity(intent);
					
				}
				
			});
			return convertView;
		}
	}

	class ViewHolder {
		ImageView photo;
		TextView name;
		TextView content;
		TextView time;
		TextView unreadCnt;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position,
			long arg3) {
		ChatFriend chatFriend = (ChatFriend) mList.getItemAtPosition(position);
		Intent intent = new Intent(this, ChatMsgActivity.class);
		intent.putExtra("toid", chatFriend.getToid());
		intent.putExtra("toname", chatFriend.getToname());
		intent.putExtra("type", chatFriend.getMsgType());
		intent.putExtra("userImage", chatFriend.getUserImage());
		startActivity(intent);
	}

	private DatabaseHelper getHelper() {
		if (database == null) {
			database = OpenHelperManager.getHelper(this, DatabaseHelper.class);

		}
		return database;
	}

	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(ACTION_NAME)) {
				Log.d(TAG,"----------->BroadcastReceiver："
						+ ACTION_NAME);
				initContent();
			}
		}
	};

	public void registerBoradcastReceiver() {
		IntentFilter myIntentFilter = new IntentFilter();
		myIntentFilter.addAction(ACTION_NAME);
		// 注册广播
		registerReceiver(mBroadcastReceiver, myIntentFilter);
	}


	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:

				Bundle bundle = (Bundle) msg.obj;
				int position = bundle.getInt("position");
				//String querytoid = bundle.getString("toid");
				String result = bundle.getString("response");
				String resultStr = "";
				if (AppUtility.isNotEmpty(result)) {
					try {
						resultStr = new String(Base64.decode(bundle.getString(
								"response").getBytes("GBK")));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

				if (AppUtility.isNotEmpty(resultStr)) {
					try {
						JSONObject jo = new JSONObject(resultStr);
						String content = jo.optString("CONTENT");
						String datetime = jo.optString("DATETIME");
						ChatFriend chatFriend = chatFriendList.get(position);
						chatFriend.setLastContent(content);
						chatFriend.setLastTime(DateHelper.getStringDate(
								datetime, "yyyy-MM-dd HH:mm:ss"));

						mAdapter.notifyDataSetChanged();
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				break;
			}
		}
	};
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
		unregisterReceiver(mBroadcastReceiver);
		
		
	}
}
