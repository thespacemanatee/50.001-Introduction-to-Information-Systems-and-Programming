
public class Test {
	
	public static void main(String[] args) {
		
		Topic topic50001 = new Topic();
		Subscriber sunardi = new Subscriber(topic50001);
		Subscriber william = new Subscriber(topic50001);
		
		topic50001.postMessage("quiz tmr!!");
		
		Subscriber man = new Subscriber(topic50001);
		topic50001.postMessage("exam next week!!");
		
		topic50001.unregister(man);
		
		topic50001.postMessage("Great!! man has gone!");
		
		
		
	}

}
