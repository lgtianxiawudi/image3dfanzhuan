package com.ligang.demo;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

public class MyOnClickLIstener implements OnClickListener {

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
	Dialog dialogs;
	public MyOnClickLIstener(Dialog dialog) {
		super();
		this.dialogs = dialog;
	}
	
}
