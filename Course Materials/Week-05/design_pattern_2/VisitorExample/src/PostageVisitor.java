
public class PostageVisitor implements Visitor {

	private double total;
	
	
	public double getTotal() {
		return total;
	}

	@Override
	public void visit(Book b) {
		total += b.getWeight() *2;
		
	}

	@Override
	public void visit(CD c) {
		if (c.getArtist() == "psy" ){
			total += 10;
		}
		else 
			total += 2;
		
	}

	@Override
	public void visit(Clothing c) {
		total += c.getSize() * 2;
		
	}
	

}
