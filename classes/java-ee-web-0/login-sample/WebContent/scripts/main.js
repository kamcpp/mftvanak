$(document)
		.ready(
				function() {
					var validationOk = true;
					$("#signup-submit")
							.click(
									function() {
										if ($("#signup-name").prop("value") == "") {
											if ($("#name-error-message").length == 0) {
												$("#signup-name")
														.after(
																"<span id='name-error-message' class='error'>Name is mandatory.</span>");
											}
											validationOk = false;
										} else {
											$("#name-error-message").remove();
											validationOk = true;
										}
										if (validationOk) {
											$("#signup-form").submit();
										}
									});

					$("#signup-username")
							.focusout(
									function() {
										$
												.ajax({
													type : "POST",
													url : "check-username.jsp?u="
															+ $(this).prop(
																	"value"),
													success : function(content) {
														if (content.result == "yes") {
															if ($("#username-error-message").length == 0) {
																$(
																		"#signup-username")
																		.after(
																				"<span id='username-error-message' class='error'>Username exists.</span>");
															}
															validationOk = false;
														} else {
															$(
																	"#username-error-message")
																	.remove();
															validationOk = true;
														}
													}
												});
									});
				});