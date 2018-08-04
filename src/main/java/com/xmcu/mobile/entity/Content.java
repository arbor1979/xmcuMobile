package com.xmcu.mobile.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * 
 *  #(c) ruanyun PocketCampus <br/>
 *
 *  鐗堟湰璇存槑: $id:$ <br/>
 *
 *  鍔熻兘璇存槑: 璇惧爞娴嬮獙鍐呭椤?
 * 
 *  <br/>鍒涘缓璇存槑: 2013-11-29 涓婂崍8:59:16 zhuliang  鍒涘缓鏂囦欢<br/>
 * 
 *  淇敼鍘嗗彶:<br/>
 *
 */
@DatabaseTable(tableName="Content")
public class Content implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	final static String TESTENTITYID= "testentity_id";
	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField
	private int testId;
	/**
	 * 鏄庣粏椤?
	 */
	@DatabaseField
	private String name;
	/**
	 * 瀛︾敓绛旀
	 */
	@DatabaseField
	private String stu_answer;
	/**
	 * 姝ｇ‘绛旀
	 */
	@DatabaseField
	private String true_answer;
	/**
	 * 澶栭敭TestEntity
	 */
//	@DatabaseField(foreign=true,foreignAutoCreate=true,foreignColumnName=TESTENTITYID)
//	private TestEntity testEntity;
	List<ContentOptions> optionsList;
	public Content(){
		
	}
	
	public Content(JSONObject jo){
		this.name = jo.optString("鏄庣粏椤?");
		this.stu_answer = jo.optString("瀛︾敓绛旀");
		this.true_answer = jo.optString("姝ｇ‘绛旀");
		this.optionsList = ContentOptions.toList(jo.optJSONArray("閫夐」"));
//		this.testEntity = testEntity;
	}
	
	public static List<Content> toList(JSONArray ja) {
		List<Content> result = new ArrayList<Content>();
		Content info = null;
		if (ja.length() == 0) {
			return null;
		} else {
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo = ja.optJSONObject(i);
				info = new Content(jo);
				result.add(info);
			}
			return result;
		}
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStu_answer() {
		return stu_answer;
	}
	public void setStu_answer(String stu_answer) {
		this.stu_answer = stu_answer;
	}
	public String getTrue_answer() {
		return true_answer;
	}
	public void setTrue_answer(String true_answer) {
		this.true_answer = true_answer;
	}

	public List<ContentOptions> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(List<ContentOptions> optionsList) {
		this.optionsList = optionsList;
	}
	
	
}
