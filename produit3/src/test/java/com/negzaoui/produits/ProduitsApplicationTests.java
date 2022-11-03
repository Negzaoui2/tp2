package com.negzaoui.produits;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.negzaoui.produits.entities.Categorie;
import com.negzaoui.produits.entities.Produits;
import com.negzaoui.produits.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {
	@Autowired
	private ProduitRepository produitRepository;

	@Test
	public void testCreateProduit() {
		Produits prod = new Produits("PC Dell", 2200.500, new Date());
		produitRepository.save(prod);
	}

	@Test
	public void testFindProduit() {
		Produits p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produits p = produitRepository.findById(1L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);

	}

	@Test
	public void testListerTousProduits() {
		List<Produits> prods = produitRepository.findAll();
		for (Produits p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindProduitByNom() {
		List<Produits> prods = produitRepository.findByNomProduit("PC Dell");
		for (Produits p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduitContains() {
		List<Produits> prods = produitRepository.findByNomProduitContains("PC Dell");
		for (Produits p : prods) {
			System.out.println(p);
		}
	}

	@Test

	public void testfindByNomPrix() {
		List<Produits> prods = produitRepository.findByNomPrix("PC HP", 1000.0);
		for (Produits p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(2L);
		List<Produits> prods = produitRepository.findByCategorie(cat);
		for (Produits p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void findByCategorieIdCat() {
		List<Produits> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produits p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByOrderByNomProduitAsc() {
		List<Produits> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produits p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testTrierProduitsNomsPrix() {
		List<Produits> prods = produitRepository.trierProduitsNomsPrix();
		for (Produits p : prods) {
			System.out.println(p);
		}
	}

}