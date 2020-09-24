import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Visitable> items = new ArrayList<Visitable>();
		items.add(new Book(10));
		items.add(new CD("psy"));
		items.add(new Book(20));
		items.add(new Clothing(20));
		
		
		PostageVisitor postage = new PostageVisitor();
		
		for (Visitable o: items	)
			o.accept(postage);
		
		System.out.println(postage.getTotal());
		
	}
	/*
	public static double calPostage(ArrayList<Object> items) {
		double total=0;
		for (Object o: items) {
			if (o instanceof Book) {
				Book b = (Book) o;
				total += b.getWeight() * 5;
				
			}
			else if (o instanceof CD) {
				CD c = (CD) o;
				if (c.getArtist() == "psy" )
					total += 5;
				else
					total += 2;
				
			}
			else if (o instanceof Clothing) {
				Clothing c = (Clothing ) o;
				total += c.getSize() *2;
			}
			else 
				throw new AssertionError("not supported");
			
		}
		return total;
	}

		*/
	
}


class Book implements Visitable {
	private double weight;
	

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}

	public Book (double weight) {
		this.weight=weight;
	}

	public double getWeight() {
		return weight;
	}

}

class CD implements Visitable {

	private String artist;
	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	
	public CD (String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	


}


class Clothing implements Visitable {
	
	private double size;

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	
	public Clothing ( double size) {
		this.size = size;

	}
	
	public double getSize() {
		return size;
	}
}