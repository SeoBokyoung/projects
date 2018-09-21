$(function(){
				
				// 닉네임을 입력하고 포커스가 빠질 때 중복체크 요청
				$('input[name=nick]').focusout(function(){
					
					var tag = $(this);
					var param = '?check=nick&value='+tag.val();
										
					$.ajax({
						url: '/jboard2/member/checkUser.do'+param,
						type: 'get',
						dataType: 'json',
						success: function( data ){
							
							if(data.result == 1) {
								$('.resultNick').css('color', 'red').text('이미 사용중인 닉네임입니다.');
								tag.focus();
							} else {
								$('.resultNick').css('color', 'green').text('사용 가능한 닉네임입니다.');
							}
						}
					});
				});
				
			});