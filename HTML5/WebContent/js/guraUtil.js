//������ �Լ��� �̿��ؼ� ArrayList �����
	ArrayList = function ArrayList(){
		this.list=[]; //�����͸� �����Ҽ� �ִ� �迭�� �ɹ��ʵ�� �����Ѵ�.
		//���ڷ� ���޵Ǵ� �����͸� �����ϴ� �Լ�
		this.add = function(item){
			//���ڷ� ���޵� �����͸� �ڱ� �ڽ��� �ʵ忡 �����Ѵ�.
			this.list.push(item);
		};
		//���ڷ� ���޵Ǵ� �ش� �ε����� ���� �����ϴ� �Լ�
		this.get = function(index){
			return this.list[index];
		};
		//���� ����� ũ�⸦ �����ϴ� �޼ҵ�
		this.size = function(){
			return this.list.length;
		};
		//����� ��� ��Ҹ� �����ϴ� �޼ҵ�
		this.removeAll = function(){
			this.list=[]; //��迭�� �����ؼ� �����ϴ� ȿ���� �ش�.
		};
		this.remove = function(index){
			//���ο�迭�� �����Ѵ�.
			var newList=[];
			//�ݺ��� ���鼭 ���ڷ� ���޵� �ε����� ������ ����Ҹ� �� �迭�� ��´�.
			for(var i=0 ; i < this.list.length ; i++){
				if( i != index){ //������ �ε����� �ƴ϶��
					newList.push(this.list[i]);
				}
			}
			//���� ���� �迭�� �ɹ� �ʵ忡 �����Ѵ�.
			this.list = newList;
		};
	}
	
	
	
	
	
	
	
	
	