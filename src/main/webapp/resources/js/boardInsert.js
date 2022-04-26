function insert_check() {
	
  	let title = $('#title').val();
  	let text = $('#text').val();
      	
  	$('#title_check').text('');
  	$('#text_check').text('');
    	
  	
  	if (title == "") {
  		$('#title_check').text('제목 입력(필수)');
  		$('#title_check').css('color', 'red');
  		$('#title').focus();
  		
  		return false;
  	}
  	
  	if (text == "") {
  		$('#text_check').text('내용 입력(필수)');
  		$('#text_check').css('color', 'red');
  		$('#text').focus();
  		
  		return false;
  	}
  	
  	if (confirm('저장하시겠습니까?'))	{
	
  		document.getElementById('boardInsert').submit();

  		return true;

  	} else {
	
  		return false;
  	}
};
  
