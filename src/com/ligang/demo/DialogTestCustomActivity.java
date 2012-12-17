package com.ligang.demo;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DialogTestCustomActivity extends Activity implements OnGestureListener {
    /** Called when the activity is first created. */
	ImageView iv;
	GestureDetector gestureDetector;
	View view2;
	private MyTask myTask;
	private Timer timer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureDetector=new GestureDetector(this);
        FrameLayout frameLayout=new FrameLayout(this);
        View view=LayoutInflater.from(this).inflate(R.layout.main,null);
        view2=LayoutInflater.from(this).inflate(R.layout.toolbar,null);
        frameLayout.addView(view);
        frameLayout.addView(view2);
        setContentView(frameLayout);
        
        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			MyDialog dialog=new MyDialog(DialogTestCustomActivity.this);
			dialog.setTitle("Test Ligang");
			dialog.setMessage("LIGANGsdfasdgszdfssssasdgadgasdfgasdgasdgagasdgfasdgfasdgasdg");
			dialog.setCancelable(false);
			dialog.setCanceledOnTouchOutside(false);
			dialog.addButton1("YES",new MyOnClickLIstener(dialog){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					System.out.println("Yes");
					dialogs.cancel();
					super.onClick(v);
				}
			});
			dialog.addButton2("NO",new MyOnClickLIstener(dialog){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					System.out.println("No");
					dialogs.cancel();
					super.onClick(v);
				}
			});
			dialog.show();
			}
		});
        Button buttons =(Button)findViewById(R.id.button2);
        buttons.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				initToast(DialogTestCustomActivity.this,"asdfasdfafasdfsdfasdfasdf");
			}
		});
        timer=new Timer();
    }
    public void initToast(Context context, String toastStr) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View Toastview = inflater.inflate(R.layout.toastlayout, null);
		TextView toasttext = (TextView) Toastview.findViewById(R.id.toasttext);
		ImageView toastimage=(ImageView)Toastview.findViewById(R.id.imagetoast);
		toasttext.setText(toastStr);
		Toast newtoast = new Toast(context);
		newtoast.setGravity(Gravity.CENTER, 0, 0);
		newtoast.setDuration(Toast.LENGTH_SHORT);
		newtoast.setView(Toastview);
		applyRotation(toastimage,0,0,360);
		newtoast.show();
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
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		if(e.getAction()==MotionEvent.ACTION_UP){
			if(view2.getVisibility()==View.VISIBLE){
				if(myTask!=null){
					myTask.cancel();
					myTask=null;
				}
				TranslateAnimation animation=new TranslateAnimation(0,0,0,-view2.getHeight());
				view2.startAnimation(animation);
				animation.setDuration(2000);
				animation.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						view2.setVisibility(View.INVISIBLE);	
					}
				});
			}else{
				view2.setVisibility(View.VISIBLE);
				TranslateAnimation animation=new TranslateAnimation(0,0,-view2.getHeight(),0);
				view2.startAnimation(animation);
				animation.setDuration(2000);
				myTask=new MyTask();
				timer.schedule(myTask, 8000);
			}
		}
		return false;
	}
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	// TODO Auto-generated method stub
    	return gestureDetector.onTouchEvent(event);
    }
    class MyTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Message mesasge = new Message();
			mesasge.what = 1;
			handler.sendMessage(mesasge);
		}
    	
    }
    Handler handler=new Handler(){
    	public void handleMessage(Message msg) {
    		TranslateAnimation animation=new TranslateAnimation(0,0,0,view2.getHeight());
			view2.startAnimation(animation);
			animation.setDuration(2000);
			animation.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					view2.setVisibility(View.INVISIBLE);	
				}
			});
    		if(myTask!=null){
    			myTask.cancel();
    			myTask=null;
    		}
    	};
    };
}