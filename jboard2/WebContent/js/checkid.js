$(function(){
				
				// 아이디를 입력하고 포커스가 빠질 때 중복체크 요청
				$('input[name=id]').focusout(function(){
					
					var tag = $(this);
					/*
					// 최소 4자리가 안되었을 경우
					if() {
						return false;
					}
				
					// 영어 소문자로 시작하지 않았을 때
					if(){
						return false;
					}
					
					// 한글일 경우
					if(){
						return false;
					}
					*/
					var uid  = tag.val();
					var param = '?check=uid&value='+uid;
										
					$.ajax({
						url: '/jboard2/member/checkUser.do'+param,
						type: 'get',
						dataType: 'json',
						success: function( data ){
							
							if(data.result == 1) {
								$('.resultId').css('color', 'red').text('이미 사용중인 아이디입니다.');
								tag.focus();
							} else {
								$('.resultId').css('color', 'green').text('사용 가능한 아이디입니다.');
							}
						}
					});
				});
				
			});