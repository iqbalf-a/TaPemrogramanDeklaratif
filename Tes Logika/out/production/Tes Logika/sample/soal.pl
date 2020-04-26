pria(bambang).
ayah(bambang, darsono).
ayah(darsono, anton).

findLast(X, [X]).
findLast(X, [_|T]) :- findLast(X, T).

kali(X, 1, X) :- !.
kali(X, Y, Z) :- K is Y-1, kali(X, K, Z1), Z is X + Z1.

xor(A, B) :- A\=B.

linearList([], []).
linearList(H, [H]) :- not(is_list(H)).
linearList([H|T], Z) :- linearList(H, X), linearList(T, Y), append(X, Y, Z).

isTree(nil).
isTree(t(_,nil,nil)) :- !.
isTree(t(_,L,nil)) :- isTree(L).
isTree(t(_,L,R)) :- isTree(L), isTree(R), !.
