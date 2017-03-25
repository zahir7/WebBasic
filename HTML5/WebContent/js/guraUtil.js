//생성자 함수를 이용해서 ArrayList 만들기
	ArrayList = function ArrayList(){
		this.list=[]; //데이터를 저장할수 있는 배열을 맴버필드로 선언한다.
		//인자로 전달되는 데이터를 저장하는 함수
		this.add = function(item){
			//인자로 전달된 데이터를 자기 자신의 필드에 저장한다.
			this.list.push(item);
		};
		//인자로 전달되는 해당 인덱스의 값을 리턴하는 함수
		this.get = function(index){
			return this.list[index];
		};
		//현재 저장된 크기를 리턴하는 메소드
		this.size = function(){
			return this.list.length;
		};
		//저장된 모든 요소를 삭제하는 메소드
		this.removeAll = function(){
			this.list=[]; //빈배열을 대입해서 삭제하는 효과를 준다.
		};
		this.remove = function(index){
			//새로운배열을 정의한다.
			var newList=[];
			//반복문 돌면서 인자로 전달된 인덱스를 제외한 모든요소를 새 배열에 담는다.
			for(var i=0 ; i < this.list.length ; i++){
				if( i != index){ //삭제할 인덱스가 아니라면
					newList.push(this.list[i]);
				}
			}
			//새로 만든 배열을 맴버 필드에 저장한다.
			this.list = newList;
		};
	}
	
	
	
	
	
	
	
	
	