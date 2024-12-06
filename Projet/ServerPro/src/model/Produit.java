package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Produit implements Serializable, List<Produit> {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nom;
    private String categorie;
    private int quantite;
    private double prix;

    public Produit(int id, String nom, String categorie, int quantite, double prix) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.quantite = quantite;
        this.prix = prix;
    }

   
    
    
    public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getCategorie() {
		return categorie;
	}




	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}




	public int getQuantite() {
		return quantite;
	}




	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}




	public double getPrix() {
		return prix;
	}




	public void setPrix(double prix) {
		this.prix = prix;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", categorie='" + categorie + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }




	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public Iterator<Produit> iterator() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public boolean add(Produit e) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean addAll(Collection<? extends Produit> c) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean addAll(int index, Collection<? extends Produit> c) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public Produit get(int index) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Produit set(int index, Produit element) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void add(int index, Produit element) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public Produit remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public ListIterator<Produit> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public ListIterator<Produit> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Produit> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
