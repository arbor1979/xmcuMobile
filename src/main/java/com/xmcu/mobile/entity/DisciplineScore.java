package com.xmcu.mobile.entity;

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
 *  鍔熻兘璇存槑: 璇勫垎锛堟墸鍒嗭紝鍔犲垎锛?
 *  "鑰冨嫟鍚嶇О":"鍑哄嫟,杩熷埌,缂哄嫟,璇峰亣",
 "鑰冨嫟鍒嗗??":"1,-1,-3,0,0",
 "鍔犲垎鍚嶇О":"瀹屾垚浣滀笟鑹ソ,璇惧爞绉瀬鍙戣█,鎾板啓璇惧爞绗旇",
 "鍔犲垎鍒嗗??":"1,1,1",
 "鍑忓垎鍚嶇О":"鐜╂墜鏈恒?佸皬澹拌璇濄?侀殢鎰忚蛋鍔ㄣ?佹壈涔辫鍫?",
 "鍑忓垎鍒嗗??":"-1,-1,-1,-2",
 *  
 *  <br/>鍒涘缓璇存槑: 2013-11-22 涓嬪崍4:19:23 linrr  鍒涘缓鏂囦欢<br/>
 * 
 *  淇敼鍘嗗彶:<br/>
 *
 */
@DatabaseTable(tableName="DisciplineScore")
public class DisciplineScore {
	@DatabaseField
	private String disciplineName;//鑰冨嫟鍚嶇О
		@DatabaseField
	private String disciplineScore;//鑰冨嫟鍒嗗??
		@DatabaseField
	private String addScoreName;//鍔犲垎鍚嶇О
		@DatabaseField
		private String addScore;//鍔犲垎鍒嗗??
		@DatabaseField
	private String minusName;//鍑忓垎鍚嶇О
		@DatabaseField
		private String minusScore;//鍑忓垎鍒嗗??
		private String disciplineName1[];
		private String disciplineScore1[];
		private String addScoreName1[];//鍔犲垎鍚嶇О
		private String addScore1[];//鍔犲垎鍚嶇О
		private String minusName1[];//鍔犲垎鍚嶇О
		private String minusScore1[];	//鍔犲垎鍚嶇О
		public DisciplineScore(){}
		public DisciplineScore(JSONObject jo) {
			disciplineName1 = getResult(jo,"鑰冨嫟鍚嶇О");
			System.out.println(disciplineName1.toString()+">>>>>>>>>>>>>>>>>>>");
			disciplineScore1 =getResult(jo,"鑰冨嫟鍒嗗??");
			//for(int i=0;i<disciplineName1.length;i++){
				if(disciplineName1[0].equals("鍑哄嫟")){
					disciplineScore1[0]=1+"";
				}else if(disciplineName1[1].equals("杩熷埌")){
					disciplineScore1[1]=-1+"";
				}
				else if(disciplineName1[2].equals("缂哄嫟")){
					disciplineScore1[2]=-3+"";
				}
				else if(disciplineName1[3].equals("璇峰亣")){
					disciplineScore1[3]=0+"";
				}
			//}
			addScoreName1 = getResult(jo,"鍔犲垎鍚嶇О");
			addScore1 =getResult(jo, "鍔犲垎鍒嗗??");
			//for(int i=0;i<addScoreName1.length;i++){
				if(addScoreName1[0].equals("瀹屾垚浣滀笟鑹ソ")){
					addScore1[0]=1+"";
				}else if(addScoreName1[1].equals("璇惧爞绉瀬鍙戣█")){
					addScore1[1]=1+"";
				}
				else if(addScoreName1[2].equals("鎾板啓璇惧爞绗旇")){
					addScore1[2]=1+"";
				}
			//}
			minusName1 = getResult(jo,"鍑忓垎鍚嶇О");
			minusScore1 =getResult(jo,"娓涘垎鍒嗗??");
			//for(int i=0;i<minusName1.length;i++){
				if(minusName1[0].equals("鐜╂墜鏈?")){
					minusScore1[0]=-1+"";
				}else if(minusName1[1].equals("灏忓０璇磋瘽")){
					minusScore1[1]=-1+"";
				}
				else if(minusName1[2].equals("闅忔剰璧板姩")){
					minusScore1[2]=-1+"";
				}
				else if(minusName1[2].equals("鎵颁贡璇惧爞")){
					minusScore1[2]=-2+"";
				}
			//}
			disciplineName = parse(disciplineName1);
			disciplineScore=parse(disciplineScore1);
			addScoreName = parse(addScoreName1);
			addScore=parse(addScore1);
			minusName = parse(minusName1);
			minusScore=parse(minusScore1);
		}
		private String[] getResult(JSONObject jo, String key) {
			JSONArray ja = jo.optJSONArray(key);
			String[] result = null;
			if (ja != null) {
				result = toStrArray(ja);
			}
			System.out.println(result.toString());
			return result;
//			
		}
/**
 * 鍔熻兘鎻忚堪:
 *灏嗗瓧绗︿覆鏁扮粍杞崲鎴愬瓧绗︿覆
 * @author linrr  2013-11-22 涓嬪崍4:41:57
 * 
 * @param result
 * @return
 */
		public String parse(String[] result){
			StringBuffer strbuff = new StringBuffer();

		for (int i = 0; i < result.length; i++) {
			strbuff.append(",").append(result[i]);
		}

		String str = strbuff.deleteCharAt(0).toString();
		return str;
		}
		private String[] toStrArray(JSONArray ja) {
			String[] strArray = new String[ja.length()];
			for (int i = 0; i < ja.length(); i++) {
				strArray[i] = ja.optString(i);
			}
			return strArray;
		}
		public String getDisciplineName() {
			return disciplineName;
		}
		public void setDisciplineName(String disciplineName) {
			this.disciplineName = disciplineName;
		}
		public String getDisciplineScore() {
			return disciplineScore;
		}
		public void setDisciplineScore(String disciplineScore) {
			this.disciplineScore = disciplineScore;
		}
		public String getAddScoreName() {
			return addScoreName;
		}
		public void setAddScoreName(String addScoreName) {
			this.addScoreName = addScoreName;
		}
		public String getAddScore() {
			return addScore;
		}
		public void setAddScore(String addScore) {
			this.addScore = addScore;
		}
		public String getMinusName() {
			return minusName;
		}
		public void setMinusName(String minusName) {
			this.minusName = minusName;
		}
		public String getMinusScore() {
			return minusScore;
		}
		public void setMinusScore(String minusScore) {
			this.minusScore = minusScore;
		}
}
