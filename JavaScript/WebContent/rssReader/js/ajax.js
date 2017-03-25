
//XMLHttpRequest 객체를 얻어오는 JavaScript
var httpRequest=null;
//Explore 브라우저 인지 확인하는 플레그값 두기
var isExplore=true;
	function getXmlHttpReqeust(){
		
		//브라우저 가 윈도우 계열일때
		if(window.ActiveXObject){
			isExplore=true;
			try{
				return new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					return new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e2){
					return null;
				}
			}
		//브라우저가 표준 계열일때
		}else if(window.XMLHttpRequest){
			isExplore=false;
			return new XMLHttpRequest();
		}else{
			return null;
		}
	}