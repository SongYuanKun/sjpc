package weibo4j.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

@Entity
@Table(name = "status")
public class Status extends WeiboResponse {
	@Transient
	private static final long serialVersionUID = -8795691786466526420L;

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	private String mid; // 微博MID

	@Column(name = "user_id")
	private String userId;
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user = null; // 作者信息
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt; // status创建时间
	private String id; // status id
	@Transient
	private Long idstr; // 保留字段，请勿使用
	private String text; // 微博内容

	@Column(name = "source_id")
	private String sourceId;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "source_id", insertable = false, updatable = false)
	private Source source; // 微博来源
	@Transient
	private Boolean favorited; // 是否已收藏
	@Transient
	private Boolean truncated;
	private Long inReplyToStatusId; // 回复ID
	private Long inReplyToUserId; // 回复人ID
	private String inReplyToScreenName; // 回复人昵称
	private String thumbnailPic; // 微博内容中的图片的缩略地址
	private String bmiddlePic; // 中型图片
	private String originalPic; // 原始图片
	@Column(name = "retweeted_status_id")
	private String retweetedStatusId;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "retweeted_status_id", insertable = false, updatable = false)
	private Status retweetedStatus = null; // 转发的博文，内容为status，如果不是转发，则没有此字段
	private String geo; // 地理信息，保存经纬度，没有时不返回此字段
	@Column(name = "geo_name")
	private String geoName;// 地理信息的名字
	private Double latitude = -1d; // 纬度
	private Double longitude = -1d; // 经度
	private Integer repostsCount; // 转发数
	private Integer commentsCount; // 评论数
	@Transient
	private String annotations; // 元数据，没有时不返回此字段
	private Integer mlevel;

	@Column(name = "visible_id")
	private Integer visibleId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "visible_id", insertable = false, updatable = false)
	private Visible visible;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getIdstr() {
		return idstr;
	}

	public void setIdstr(Long idstr) {
		this.idstr = idstr;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Boolean getFavorited() {
		return favorited;
	}

	public void setFavorited(Boolean favorited) {
		this.favorited = favorited;
	}

	public Boolean getTruncated() {
		return truncated;
	}

	public void setTruncated(Boolean truncated) {
		this.truncated = truncated;
	}

	public Long getInReplyToStatusId() {
		return inReplyToStatusId;
	}

	public void setInReplyToStatusId(Long inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}

	public Long getInReplyToUserId() {
		return inReplyToUserId;
	}

	public void setInReplyToUserId(Long inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}

	public String getInReplyToScreenName() {
		return inReplyToScreenName;
	}

	public void setInReplyToScreenName(String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}

	public String getThumbnailPic() {
		return thumbnailPic;
	}

	public void setThumbnailPic(String thumbnailPic) {
		this.thumbnailPic = thumbnailPic;
	}

	public String getBmiddlePic() {
		return bmiddlePic;
	}

	public void setBmiddlePic(String bmiddlePic) {
		this.bmiddlePic = bmiddlePic;
	}

	public String getOriginalPic() {
		return originalPic;
	}

	public void setOriginalPic(String originalPic) {
		this.originalPic = originalPic;
	}

	public Status getRetweetedStatus() {
		return retweetedStatus;
	}

	public void setRetweetedStatus(Status retweetedStatus) {
		this.retweetedStatus = retweetedStatus;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getGeoName() {
		return geoName;
	}

	public void setGeoName(String geoName) {
		this.geoName = geoName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getRepostsCount() {
		return repostsCount;
	}

	public void setRepostsCount(Integer repostsCount) {
		this.repostsCount = repostsCount;
	}

	public Integer getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}

	public String getAnnotations() {
		return annotations;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public Integer getMlevel() {
		return mlevel;
	}

	public void setMlevel(Integer mlevel) {
		this.mlevel = mlevel;
	}

	public Integer getVisibleId() {
		return visibleId;
	}

	public void setVisibleId(Integer visibleId) {
		this.visibleId = visibleId;
	}

	public Visible getVisible() {
		return visible;
	}

	public void setVisible(Visible visible) {
		this.visible = visible;
	}

	public Status() {
	}

	/***
	 * 
	 * @param mid
	 *            微博ID
	 * @param userId
	 *            用户ID
	 * @param createdAt
	 *            创建日期
	 * @param text
	 *            微博文本
	 * @param source
	 *            微博来源
	 * @param retweetedStatusId
	 *            微博转发
	 * @param thumbnailPic
	 *            小尺寸图片
	 */
	public Status(String mid, String userId, Date createdAt, String text, Source source, String retweetedStatusId,
			String thumbnailPic) {
		super();
		this.mid = mid;
		this.userId = userId;
		this.createdAt = createdAt;
		this.text = text;
		this.source = source;
		this.retweetedStatusId = retweetedStatusId;
		this.thumbnailPic = thumbnailPic;
		this.bmiddlePic = thumbnailPic.replace("thumb180", "mw690");
		this.originalPic = thumbnailPic.replace("thumb180", "mw1024");
	}

	public Status(Response res) throws WeiboException {
		super(res);
		JSONObject json = res.asJSONObject();
		constructJson(json);
	}

	private void getGeoInfo(String geo) {
		StringBuffer value = new StringBuffer();
		for (char c : geo.toCharArray()) {
			if (c > 45 && c < 58) {
				value.append(c);
			}
			if (c == 44) {
				if (value.length() > 0) {
					latitude = Double.parseDouble(value.toString());
					value.delete(0, value.length());
				}
			}
		}
		longitude = Double.parseDouble(value.toString());
	}

	public Status(JSONObject json) throws WeiboException, JSONException {
		constructJson(json);
	}

	public Status(String str) throws WeiboException, JSONException {
		// StatusStream uses this constructor
		super();
		JSONObject json = new JSONObject(str);
		constructJson(json);
	}

	public static StatusWapper constructWapperStatus(Response res) throws WeiboException {
		JSONObject jsonStatus = res.asJSONObject(); // asJSONArray();
		JSONArray statuses = null;
		try {
			if (!jsonStatus.isNull("statuses")) {
				statuses = jsonStatus.getJSONArray("statuses");
			}
			if (!jsonStatus.isNull("reposts")) {
				statuses = jsonStatus.getJSONArray("reposts");
			}
			int size = statuses.length();
			List<Status> status = new ArrayList<Status>(size);
			for (int i = 0; i < size; i++) {
				status.add(new Status(statuses.getJSONObject(i)));
			}
			long previousCursor = jsonStatus.getLong("previous_curosr");
			long nextCursor = jsonStatus.getLong("next_cursor");
			long totalNumber = jsonStatus.getLong("total_number");
			String hasvisible = jsonStatus.getString("hasvisible");
			return new StatusWapper(status, previousCursor, nextCursor, totalNumber, hasvisible);
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Status [user=" + user + ", idstr=" + idstr + ", createdAt=" + createdAt + ", id=" + id + ", text="
				+ text + ", source=" + source + ", favorited=" + favorited + ", truncated=" + truncated
				+ ", inReplyToStatusId=" + inReplyToStatusId + ", inReplyToUserId=" + inReplyToUserId
				+ ", inReplyToScreenName=" + inReplyToScreenName + ", thumbnailPic=" + thumbnailPic + ", bmiddlePic="
				+ bmiddlePic + ", originalPic=" + originalPic + ", retweetedStatus=" + retweetedStatus + ", geo=" + geo
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", repostsCount=" + repostsCount
				+ ", commentsCount=" + commentsCount + ", mid=" + mid + ", annotations=" + annotations + ", mlevel="
				+ mlevel + ", visible=" + visible + "]";
	}

	private void constructJson(JSONObject json) throws WeiboException {
		try {
			createdAt = parseDate(json.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
			id = json.getString("id");
			mid = json.getString("mid");
			idstr = json.getLong("idstr");
			text = json.getString("text");
			if (!json.getString("source").isEmpty()) {
				source = new Source(json.getString("source"));
			}
			inReplyToStatusId = getLong("in_reply_to_status_id", json);
			inReplyToUserId = getLong("in_reply_to_user_id", json);
			inReplyToScreenName = json.getString("in_reply_toS_screenName");
			favorited = getBoolean("favorited", json);
			truncated = getBoolean("truncated", json);
			thumbnailPic = json.getString("thumbnail_pic");
			bmiddlePic = json.getString("bmiddle_pic");
			originalPic = json.getString("original_pic");
			repostsCount = json.getInt("reposts_count");
			commentsCount = json.getInt("comments_count");
			annotations = json.getString("annotations");
			if (!json.isNull("user"))
				user = new User(json.getJSONObject("user"));
			if (!json.isNull("retweeted_status")) {
				retweetedStatus = new Status(json.getJSONObject("retweeted_status"));
			}
			mlevel = json.getInt("mlevel");
			geo = json.getString("geo");
			if (geo != null && !"".equals(geo) && !"null".equals(geo)) {
				getGeoInfo(geo);
			}
			if (!json.isNull("visible")) {
				visible = new Visible(json.getJSONObject("visible"));
			}
		} catch (JSONException je) {
			throw new WeiboException(je.getMessage() + ":" + json.toString(), je);
		}
	}
}
