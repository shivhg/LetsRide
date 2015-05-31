$(document).ready(function() {
	$("#submitb").click(function() {

		if ($('[name=areafrom]').val() == 'none') {
			alert('select current location');
			$('[name=areafrom]').focus()
			return false;
		}

		if ($('[name=areato]').val() == 'none') {
			alert('select destination');
			$('[name=areato]').focus()
			return false;
		}

		if ($('[name=areafrom]').val() == $('[name=areato]').val()) {
			alert('select different destination');
			$('[name=areato]').focus()
			return false;
		}

	});
});
