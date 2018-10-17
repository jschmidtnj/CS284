package trees;

public class BinaryTreeNotes {

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
	
	/*
	 * Binary Trees are O(n)
	 * Binary Search Trees are also O(n)
	 * With restrictions, binary search trees can become O(logn)
	 * 
	 * Full binary tree - each node has either 0 or 2 children
	 * 
	 * Perfect binary tree - full binary tree with all leaves having the same depth (completely filled up) - (2^n - 1) nodes
	 * 
	 * Complete binary tree - perfect tree from every level but the leaf level. Leaf level must be filled in left to right
	 * 
	 * Tree Traversals
	 * 3 standard kinds of traversals - inorder, preorder, and postorder (also level traversals)
	 * 
	 * preorder goes down the list and takes first element, postorder goes down the list and saves when going back up, inorder
	 * goes down the list and saves every time you go right or up (do not save twice)
	 * 
	 * 				a
	 * 		    b		c
	 * 		 d    _   e	   f
	 * 
	 * preorder: [a,b,d,c,e,f]
	 * postorder: [d,b,e,f,c,a]
	 * inorder: [d,b,a,e,c,f]
	 */
}
