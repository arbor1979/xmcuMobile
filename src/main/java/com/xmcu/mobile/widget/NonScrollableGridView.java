package com.xmcu.mobile.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * 瑙ｅ喅Add a GridView to a ListView
 * 
 * @Title NonScrollableGridView.java
 * @Description: TODO
 * 
 * @author Zecker
 * @date 2013-10-30 涓嬪崍3:33:56
 * @version V1.0
 * 
 */
public class NonScrollableGridView extends GridView {
//	public NonScrollableGridView(Context context) {
//		super(context);
//	}
//
//	public NonScrollableGridView(Context context, AttributeSet attrs) {
//		super(context, attrs);
//	}
//
//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		// Do not use the highest two bits of Integer.MAX_VALUE because they are
//		// reserved for the MeasureSpec mode
//		int heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
//				MeasureSpec.AT_MOST);
//		super.onMeasure(widthMeasureSpec, heightSpec);
//		getLayoutParams().height = getMeasuredHeight();
//	}
	public NonScrollableGridView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		}
		public NonScrollableGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		}

		public NonScrollableGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		}
		     
		//閫氳繃閲嶆柊dispatchTouchEvent鏂规硶鏉ョ姝㈡粦鍔?
		@Override
		public boolean dispatchTouchEvent(MotionEvent ev) {
		if(ev.getAction() == MotionEvent.ACTION_MOVE){
		   return true;//绂佹Gridview杩涜婊戝姩
		}
		return super.dispatchTouchEvent(ev);
		}
}

