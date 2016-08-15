package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;

public class GetPublicTimeline {

	public static void main(String[] args) {
		String access_token = "2.00p5nQcDYcNYoBb30c81e3b3NTWaqD";
		Timeline tm = new Timeline(access_token);
		try {
			StatusWapper status = tm.getPublicTimeline();
			Log.logInfo(status.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
