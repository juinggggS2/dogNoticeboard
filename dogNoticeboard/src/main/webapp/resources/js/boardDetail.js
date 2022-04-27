function delete_check(){

	if (confirm('삭제하시겠습니까?'))	{
	
  		document.getElementById('boardDelete').submit();

  		return true;

  	} else {
	
  		return false;
  	}

};