package com.jungsoo.web.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpConnectionUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpConnectionUtil.class);

	public static String postRequest(String pUrl, HashMap<String, String> pMap)
		throws IOException {

		//접속 url 설정
		URL url = new URL(pUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();	//접속
		//전송모드 설정
		conn.setConnectTimeout(5000);
		conn.setDoOutput(true);	//서버로  쓰기모드 지정
		conn.setDoInput(true);	//서버로 읽기모드 지정
		conn.setRequestMethod("POST");	//전송방식

		//헤더 설정
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		//서버로 전송값 설정
		StringBuffer sb = new StringBuffer();
		if (pMap != null) {
			Set<String> key = pMap.keySet();
			for (Iterator<String> itr = key.iterator(); itr.hasNext();) {
				String keyName = itr.next();
				String valueName = pMap.get(keyName);

				sb.append(keyName).append("=").append(valueName).append("&");
			}
		}
		String pSbString = sb.toString();
		pSbString = pSbString.substring(0, pSbString.length() - 1);
		LOGGER.debug("HttpConnectionUtil.postRequest send param: {} / {}", pUrl, pSbString);

		OutputStream os = conn.getOutputStream();
		os.write(pSbString.getBytes("UTF-8"));
		os.close();

		//서버로부터 전송결과 받기
		InputStreamReader in = new InputStreamReader(conn.getInputStream());
		BufferedReader br = new BufferedReader(in);
		StringBuilder sbi = new StringBuilder();
		String tmpLine = "";
		while ((tmpLine = br.readLine()) != null) {
			sbi.append(tmpLine);
		}
		LOGGER.debug("HttpConnectionUtil.postRequest reponse: {}", sbi.toString());

		return sbi.toString();
	}

	public static void main(String[] args) throws Exception{
		//open door
		String pUrl = "http://192.168.0.19:8090/device/openDoorControl";
		HashMap<String, String> pMap = new HashMap<String, String>();
		pMap.put("pass", "12345678");

		//정보삭제
		pUrl = "http://192.168.0.18:8090/person/delete";
		pMap = new HashMap<String, String>();
		pMap.put("pass", "12345678");
		pMap.put("id", "M202001489");
		postRequest(pUrl, pMap);

		//정보등록
		/*		pUrl = "http://192.168.0.19:8090/person/create";
		pMap = new HashMap<String, String>();
		pMap.put("id", "M202000001");
		pMap.put("idCardNum", "M202000001");
		pMap.put("name", "서울일");
		String pJsonString = new Gson().toJson(pMap);

		pMap = new HashMap<String, String>();
		pMap.put("pass", "12345678");
		pMap.put("person", pJsonString);
		String jsonStringResult = postRequest(pUrl, pMap);

		//안면등록
		JSONObject jsonObj = null;
		JSONParser jsonParsor = new JSONParser();
		jsonObj = (JSONObject) jsonParsor.parse(jsonStringResult);
		jsonObj = (JSONObject) jsonObj.get("data");
		String personId = jsonObj.get("id").toString();

		pUrl = "http://192.168.0.19:8090/face/takeImg";
		pMap = new HashMap<String, String>();
		pMap.put("pass", "12345678");
		pMap.put("personId", personId);

		postRequest(pUrl, pMap);*/

		//정보검색
/*		pUrl = "http://192.168.0.19:8090/face/find";
		pMap = new HashMap<String, String>();
		pMap.put("pass", "12345678");
		pMap.put("personId", "M202000001");
		String jsonStringResult = postRequest(pUrl, pMap);

		//파일 저장
		JSONObject jsonObj = null;
		JSONArray jsonArr = null;
		JSONParser jsonParsor = new JSONParser();
		jsonObj = (JSONObject) jsonParsor.parse(jsonStringResult);
		jsonArr = (JSONArray) jsonObj.get("data");
		jsonObj = (JSONObject) jsonArr.get(0);

		String ftpUrl = "192.168.0.19";
		int ftpPort = 8010;
		String localFacePath = "C:\\\\voyager\\\\upload\\\\memberface" + File.separator
				+ "M202000001" + "_" + jsonObj.get("faceId").toString() + ".jpg";
		String remoteFacePath = jsonObj.get("path").toString();
		String replaceString = "ftp://" + ftpUrl + ":" + ftpPort;
		remoteFacePath = remoteFacePath.replace(replaceString, "");
		LOGGER.debug("HttpConnectionUtil.main remoteFacePath: {}", remoteFacePath);
		OutputStream os = new FileOutputStream(localFacePath);

		FTPClient ftpClient = new FTPClient();
		ftpClient.connect(ftpUrl, ftpPort);
		ftpClient.login("anonymous", "");
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		boolean status = ftpClient.retrieveFile(remoteFacePath, os);
		LOGGER.debug("HttpConnectionUtil.main reponse: {}", status);

		//정보배포
		///person/create
		pUrl = "http://192.168.0.19:8090/person/create";
		pMap = new HashMap<String, String>();
		pMap.put("id", "M202000002");
		pMap.put("idCardNum", "M202000002");
		pMap.put("name", "서울이");
		String pJsonString = new Gson().toJson(pMap);

		pMap = new HashMap<String, String>();
		pMap.put("pass", "12345678");
		pMap.put("person", pJsonString);
		jsonStringResult = postRequest(pUrl, pMap);*/
		///face/create

/*		pUrl = "http://192.168.0.19:8090/face/create";
		pMap = new HashMap<String, String>();
		pMap.put("pass", "12345678");
		pMap.put("personId", "M202000002");
		pMap.put("faceId", jsonObj.get("faceId").toString());
		pMap.put("imgBase64", jsonObj.get("feature").toString());
		pMap.put("isEasyWay", "true");

		jsonStringResult = HttpConnectionUtil.postRequest(pUrl, pMap);
		jsonObj = (JSONObject) jsonParsor.parse(jsonStringResult);*/

/*		pUrl = "http://192.168.0.19:8090/face/featureReg";
		pMap = new HashMap<String, String>();
		pMap.put("pass", "12345678");
		pMap.put("personId", "M202000002");
		pMap.put("faceId", jsonObj.get("faceId").toString());
		pMap.put("feature", jsonObj.get("feature").toString());
		pMap.put("featureKey", jsonObj.get("feature").toString());

		jsonStringResult = HttpConnectionUtil.postRequest(pUrl, pMap);
		jsonObj = (JSONObject) jsonParsor.parse(jsonStringResult);*/
	}
}