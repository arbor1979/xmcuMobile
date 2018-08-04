package com.xmcu.mobile.activity;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.xmcu.mobile.R;
import com.xmcu.mobile.api.CampusAPI;
import com.xmcu.mobile.api.CampusException;
import com.xmcu.mobile.api.CampusParameters;
import com.xmcu.mobile.api.RequestListener;
import com.xmcu.mobile.base.Constants;
import com.xmcu.mobile.entity.EMSEntry;
import com.xmcu.mobile.entity.EMSEntry.EMSItemEntry;
import com.xmcu.mobile.util.AppUtility;
import com.xmcu.mobile.util.Base64;
import com.xmcu.mobile.util.PrefUtility;


public class EmsTraceActivity extends Activity {
	
	AQuery aq;
	MyAdapter adapter;
	TextView chat_msg_none;
	ListView listview;
	String emsno;
	EMSEntry emsEntry;
	private ProgressDialog mypDialog;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ems_trace);
		chat_msg_none = (TextView) findViewById(R.id.chat_msg_none);
		listview=(ListView)findViewById(R.id.message_list);
		emsno=getIntent().getStringExtra("emsno");
		
		aq = new AQuery(this);
		
		aq.id(R.id.back).clicked(new OnClickListener(){

			@Override
			public void onClick(View v) {
				finish();
			}
			
		});

		getEMSForm189(emsno);
		
	}

	private void getEMSForm189(String nu)
	{
		showProgress1(true);
		String checkCode = PrefUtility.get(Constants.PREF_CHECK_CODE, "");
		JSONObject jo = new JSONObject();
		try {
			jo.put("action", "getEMS");
			jo.put("nu", nu);
			jo.put("用户较验码", checkCode);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		String base64Str = Base64.encode(jo.toString().getBytes());
		CampusParameters params = new CampusParameters();
		params.add(Constants.PARAMS_DATA, base64Str);
		CampusAPI.getSchoolItemFrom189(params, "XUESHENG-CHENGJI-Student-EMS.php", new RequestListener() {
			@Override
			public void onIOException(IOException e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onError(CampusException e) {
				Message msg = new Message();
				msg.what = -1;
				msg.obj = e.getMessage();
				mHandler.sendMessage(msg);

			}

			@Override
			public void onComplete(String response) {
				Message msg = new Message();
				msg.what = 1;
				msg.obj = response;
				mHandler.sendMessage(msg);

			}
		});
	}

	private void getStatus(String url,CampusParameters params) {
		/*
		Date dt=new Date();
		Random generator = new Random(); 
		DecimalFormat fmt2 = new DecimalFormat ("###"); 
		int num2 = generator.nextInt(999); 
		String timestamp=String.valueOf(dt.getTime())+fmt2.format(num2);
		*/
		//String url="https://open.onebox.so.com/api/getkuaidi";
		//CampusParameters params = makeRequestParams(emsno);
		CampusAPI.getUrl(url,params, new RequestListener() {

			@Override
			public void onIOException(IOException e) {

			}

			@Override
			public void onError(CampusException e) {
				Message msg = new Message();
				msg.what = -1;
				msg.obj = e.getMessage();
				mHandler.sendMessage(msg);
			}

			@Override
			public void onComplete(String response) {
				
				Message msg = new Message();
				msg.what = 0;
				msg.obj = response;
				mHandler.sendMessage(msg);
			}
		});
	}
	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {

		public void handleMessage(Message msg) {
			switch (msg.what) {
			case -1:
				showProgress1(false);
				AppUtility.showErrorToast(EmsTraceActivity.this,
						msg.obj.toString());
				break;
			case 0:
				
				String result = msg.obj.toString();
				
				try 
				{
					JSONObject jo = new JSONObject(result);
					String loginStatus = jo.optString("errcode");
					
					if (!loginStatus.equals("0")) {
						AppUtility.showToastMsg(EmsTraceActivity.this, jo.optString("errmsg"),1);
					} else 
					{
						
						emsEntry=new EMSEntry(jo.optJSONObject("data"));
						adapter=new MyAdapter(EmsTraceActivity.this);
						listview.setAdapter(adapter);
					}
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				break;
			case 1:
				showProgress1(false);
				result = msg.obj.toString();
				try
				{
					JSONObject jo = new JSONObject(result);
					if(jo!=null && jo.optString("msg").endsWith("查询成功"))
					{
						JSONObject resultObj=jo.optJSONObject("result").optJSONObject("result");
						emsEntry=new EMSEntry(resultObj);
						adapter=new MyAdapter(EmsTraceActivity.this);
						listview.setAdapter(adapter);
					}
					else
						AppUtility.showToastMsg(EmsTraceActivity.this, jo.optString("errmsg"),1);


				} catch (Exception e) {

					e.printStackTrace();
				}

				break;
			}
		};
	};
	
	
	public class MyAdapter extends BaseAdapter{
		 
        private LayoutInflater mInflater;
        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
          
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return emsEntry.getData().size();
        }
 
        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
        	
			return emsEntry.getData().get(arg0);
			
        	
        }
 
        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }
        @Override  
        public boolean isEnabled(int position) {   
           return false;   
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
             
        	View view=convertView;  
        	view=mInflater.inflate(R.layout.list_ems_item, null);  
        	EMSItemEntry item=emsEntry.getData().get(position);
        	TextView cornerTv=(TextView)view.findViewById(R.id.cornerTv);
            TextView detail=(TextView)view.findViewById(R.id.item_textView);
            detail.setText(Html.fromHtml(item.getTime()+"<br>"+item.getLocation()));
            detail.setMovementMethod(LinkMovementMethod.getInstance());
            cornerTv.setBackgroundResource(R.drawable.corner_view_gray);
            if(emsEntry.getStatus()==1 && position==0)
            {
            	cornerTv.setBackgroundResource(R.drawable.corner_view_green);
            }
            
            return view;
        }
       
         
    }
	private void showProgress1(final boolean show) {

		if(show)
		{
			if(mypDialog==null)
				mypDialog=new ProgressDialog(this);
			//实例化
			mypDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			//设置ProgressDialog 标题
			mypDialog.setMessage("查询中，请稍候...");
			//设置ProgressDialog 提示信息
			//设置ProgressDialog 的一个Button
			mypDialog.setIndeterminate(false);
			//设置ProgressDialog 的进度条是否不明确
			mypDialog.setCancelable(false);
			//设置ProgressDialog 是否可以按退回按键取消
			mypDialog.show();
		}
		else
		{
			if(mypDialog!=null)
				mypDialog.cancel();
		}
	}

	
}
