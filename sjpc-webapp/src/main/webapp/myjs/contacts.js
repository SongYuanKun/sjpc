$(function() {

	$.post("ajax/contacts.action", function(data) {
		var statuslist = data.aaData;
		for (var i = 0; i < statuslist.length; i++) {
			setTimeout((function(statuslist, i) {
				return function() {
					var $card = $(".card:first").clone();
					$("img", $card).attr("src",
							statuslist[i]['avatarLarge'] || '');
					$("h3 strong", $card).text(
							statuslist[i]['screenName'] || '');
					$("tt[name='location']", $card).text(
							statuslist[i]['location'] || '');
					$("tt[name='followersCount']", $card).text(
							statuslist[i]['followersCount'] || '');
					$("tt[name='friendsCount']", $card).text(
							statuslist[i]['friendsCount'] || '');
					$("tt[name='createdAt']", $card).text(
							statuslist[i]['createdAt'].split('T')[0] || '');
					$("input[type='hidden']", $card).attr('value',
							statuslist[i]['id']);
					$card.removeClass("hide");
					$(".card:last").after($card);
				};
			})(statuslist, i), 0.1e3 * i);
		}

	}, "json");

	$("body").delegate('.card', 'mouseover mouseout', function(e) {
		if (e.type === 'mouseover') {
			$(this).addClass("animated pulse");
		} else if (e.type === 'mouseout') {
			$(this).removeClass("animated pulse");
		}
	});

	$("body").delegate(
			'.card',
			'click',
			function(e) {
				location = "profile.action?id="
						+ $("input[type='hidden']", $(this)).val();
			});
});
