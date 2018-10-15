package trees;

public class BinaryTree {

	/* NOTES::::
	 * 
	 * Tree Expressions
	 * dog -> (cat -> (canine, Empty), wolf)
	 * expression:
	 * Node("dog",
	 * 		Node("cat",
	 * 			Node("canine", Empty, Empty),
	 * 			Empty),
	 * 		Node("wolf", Empty, Empty)
	 * )
	 * levels start at 1 and go to the last branch
	 * internal nodes are all nodes that are not leaves.
	 * 
	 * tree expression of a function recursively to get the height of the tree:
	 * let rec height = function
	 * 	| Empty -> 0
	 * 	| Node(i, lt, rt) -> 1 + max (height lt) (height rt)
	 * 
	 * lt = left tree, rt = right tree
	 * 
	 * let rec size = function
	 * 	| Empty -> 0
	 * 	| Node(i,lt,rt) -> 1 + (size lt) + (size rt)
	 * 
	 * let rec leaves = function
	 * 	| Empty -> 0
	 * 	| Node(i,Empty,Empty) -> 1
	 * `| Node(i,lt,rt) -> leaves(lt) + leaves(rt)
	 * 
	 * let rec sumtree = function
	 * 	| Empty -> 0
	 * 	| Node(i,lt,rt) -> i + sumtree(lt) + sumtree(rt)
	 * 
	 * let rec isEmpty = function
	 * 	| Empty -> true
	 * `| Node(i, lt, rt) -> false
	 */
	
	/*
	 * Huffman Trees - used for encoding and reducing the size of text
	 * binary search tree - all numbers to the left are less than the right
	 * 
	 * let rec is_binarysearchtree t =function
	 * 		match t with
	 * 		| Empty -> true
	 * 		| Node(i,lt,rt) -> 
	 * 			min_tree(rt) > i && max_tree(lt) < i
	 * 			&& is_binarysearchtree(lt) && is_binarysearchtree(rt)
	 * 
	 * min_tree -> returns min number in tree
	 * max_tree -> returns max number in tree
	 * 
	 * let rec mem t j = function
	 * 		match t with
	 * 		| Empty-> false
	 * 		| Node(i,lt,rt) ->
	 * 			i==j || mem lt j || mem rt j
	 * let rec membst t j = function
	 * 		match t with
	 * 		| Empty-> false
	 * 		| Node(i,lt,rt) ->
	 * 			if i==j -> true
	 * 			else if i < j
	 * 				-> membst(lt,j)
	 * 				else -> membst(rt,j)
	 * 
	 * O(n) for mem, with n being the number of nodes in the tree
	 * O(log2(n)) for membst
	 * big gain
	 */
}
