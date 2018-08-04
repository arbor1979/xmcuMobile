/*
 * 	   Created by Daniel Nadeau
 * 	   daniel.nadeau01@gmail.com
 * 	   danielnadeau.blogspot.com
 * 
 * 	   Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.xmcu.mobile.entity;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EMSEntry {
	private String nu;
	private String com;
	private int status;
	private String trans_state;
	private ArrayList<EMSItemEntry> data;
	public EMSEntry(JSONObject jo) {
		super();
		this.nu = jo.optString("number");
		this.com = jo.optString("type");
		this.status = jo.optInt("issign");
		this.trans_state = jo.optString("deliverystatus");
		JSONArray ja;
		try {
			ja = jo.getJSONArray("list");
			data=new ArrayList<EMSItemEntry>();
			for(int i=0;i<ja.length();i++)
			{
				JSONObject item=(JSONObject) ja.get(i);
				EMSItemEntry itemEntry=new EMSItemEntry(item);
				if(itemEntry!=null)
					data.add(itemEntry);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getTrans_state() {
		return trans_state;
	}
	public void setTrans_state(String trans_state) {
		this.trans_state = trans_state;
	}
	public String getNu() {
		return nu;
	}
	public void setNu(String nu) {
		this.nu = nu;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ArrayList<EMSItemEntry> getData() {
		return data;
	}
	public void setData(ArrayList<EMSItemEntry> data) {
		this.data = data;
	}
	public class EMSItemEntry {
		String time;
		String location;
		
		public EMSItemEntry(JSONObject item) {
			super();
			this.time = item.optString("time");
			this.location = item.optString("status");
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}

	}
	
	
}
