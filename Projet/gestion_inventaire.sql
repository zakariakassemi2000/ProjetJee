-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 06 déc. 2024 à 16:05
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_inventaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `prix` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `nom`, `categorie`, `quantite`, `prix`) VALUES
(1, 'Produit 1', 'Catégorie A', 300, 19.99),
(3, 'Produit D', 'Catégorie 3', 30, 12.49),
(4, 'Produit D', 'Catégorie 3', 30, 12.49),
(5, 'Produit D', 'Catégorie 3', 30, 12.49),
(6, 'Produit D', 'Catégorie 3', 30, 12.49),
(7, 'Produit D', 'Catégorie 3', 30, 12.49),
(8, 'Produit D', 'Catégorie 3', 30, 12.49),
(9, 'Produit D', 'Catégorie 3', 30, 12.49),
(10, 'Produit D', 'Catégorie 3', 30, 12.49),
(11, 'Produit Exemple', 'Catégorie Exemple', 10, 19.99),
(12, 'Telephone', 'info', 100, 30.00),
(13, 'NESCAFE', 'BOISSON', 10, 1.00),
(14, 'ZAKARIA', 'INFO', 100111, 11.00);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
