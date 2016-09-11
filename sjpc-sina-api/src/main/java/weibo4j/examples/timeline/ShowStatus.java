package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;

public class ShowStatus {

	public static void main(String[] args) {
		String id = args[1];
		Timeline tm = new Timeline();
		try {
			Status status = tm.showStatus(id);
			Log.logInfo(status.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
