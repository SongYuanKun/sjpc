$(function() {
	$.post("ajax/userStatusList.action?id=" + $("#userid").val(), function(
			data) {
		var statuslist = data.aaData;
		for (var i = 0; i < statuslist.length; i++) {
			var $card = $(".feed-element.hide").clone();
			$(".day", $card).text(
					statuslist[i]['createdAt'].split('T')[0] || '');
			$(".time", $card).text(
					(statuslist[i]['createdAt'].split('T')[1] || '') + "来自"
							+ (statuslist[i]['source']['name'] || ''));
			$(".text", $card).text(statuslist[i]['text'] || '');
			if (statuslist[i]['bmiddlePic'] =="") {
				$(".photos", $card).addClass("hide");
			}
			$(".photos a", $card).attr('href', statuslist[i]['originalPic']);
			$(".photos img", $card).attr('src', statuslist[i]['bmiddlePic']);
			$card.removeClass("hide");
			$(".feed-element:last").after($card);
		}

	}, "json");
});