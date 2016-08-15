package weibo4j.examples.location;

import java.util.List;

import weibo4j.Location;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Geos;
import weibo4j.model.WeiboException;

public class GeoToAddress {

	public static void main(String[] args) {
		String geo ="112.788383,22.398491";
		Location l = new Location();
		try {
			List<Geos> list = l.geoToAddress(geo);
			for (Geos g : list) {
				Log.logInfo(g.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
