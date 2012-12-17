package com.ligang.demo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.method.DialerKeyListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyDialog extends Dialog {
	private LinearLayout titlell=null;
	private LinearLayout message=null;
	private LinearLayout button=null;
	private TextView title=null;
	private ImageView messageimage=null;
	private TextView messagetext=null;
	private Button button1=null;
	private Button button2=null;
	private View view;
	protected MyDialog(Context context) {
		super(context, R.style.Dialog);
		// TODO Auto-generated constructor stub
		view=LayoutInflater.from(context).inflate(R.layout.mains,null);
		titlell=(LinearLayout)view.findViewById(R.id.titlell);
		title=(TextView)view.findViewById(R.id.title);
		message=(LinearLayout)view.findViewById(R.id.message);
		messageimage=(ImageView)view.findViewById(R.id.imageView1);
		messagetext=(TextView)view.findViewById(R.id.test);
		button1=(Button)view.findViewById(R.id.button1);
		button2=(Button)view.findViewById(R.id.button2);
		button=(LinearLayout)view.findViewById(R.id.button);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(view);
		applyRotation(messageimage,0,0,360);
	}
	public void setTitle(String text){
		titlell.setVisibility(View.VISIBLE);
		title.setText(text);
	}
	public void setMessage(String text){
		message.setVisibility(View.VISIBLE);
		messagetext.setText(text);
	}
	public void addButton1(String text,View.OnClickListener clickListener){
		button.setVisibility(View.VISIBLE);
		button1.setVisibility(View.VISIBLE);
		button1.setText(text);
		button1.setOnClickListener(clickListener);
	}
	public void addButton2(String text,View.OnClickListener clickListener){
		button.setVisibility(View.VISIBLE);
		button2.setText(text);
		button2.setVisibility(View.VISIBLE);
		button2.setOnClickListener(clickListener);
	}
	 private void applyRotation(ImageView iv,int position, float start, float end) {  
	        final float centerX = iv.getWidth() / 2.0f;  
	        final float centerY = iv.getHeight() / 2.0f;
	        final Rotate3dAnimation rotation =  
	                new Rotate3dAnimation(start, end, centerX+20, centerY, 0, true);  
	        rotation.setDuration(1500);  
	        rotation.setRepeatCount(-1);
	        rotation.setRepeatMode(Animation.REVERSE);
	        rotation.setFillAfter(true);  
	        rotation.setInterpolator(new LinearInterpolator());  
	        iv.startAnimation(rotation);
	    }
	 @Override
	protected void onStop() {
		// TODO Auto-generated method stub
		 messageimage.clearAnimation();
		super.onStop();
	}
}
