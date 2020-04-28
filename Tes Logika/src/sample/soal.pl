%soal 1 Parent
pria(bambang).
ayah(bambang, darsono).
ayah(darsono, anton).

%soal 2 manipulasi list
findLast(X, [X]).
findLast(X, [_|T]) :- findLast(X, T).

%soal 3 aritmatika
kali(X, 1, X) :- !.
kali(X, Y, Z) :- K is Y-1, kali(X, K, Z1), Z is X + Z1.

%soal 4 logika
xor(A, B) :- A\=B.

%soal 5 list of list
linearList([], []).
linearList(H, [H]) :- not(is_list(H)).
linearList([H|T], Z) :- linearList(H, X), linearList(T, Y), append(X, Y, Z).

%soal 6 binary tree
isTree(nil).
isTree(t(_,nil,nil)) :- !.
isTree(t(_,L,nil)) :- isTree(L).
isTree(t(_,L,R)) :- isTree(L), isTree(R), !.

%soal 7 list of list
findLength(X, [H|T]) :- countLength(X, [H|T], 0).
countLength(X, [], X).
countLength(X, [_|T], C) :- D is C+1, countLength(X, T, D).

%soal 8 aritmatika
soal8(A, B, C, D) :- D is A - (B * C/2).

%soal 9 logika
equal(A, B) :- A == B.

%soal 10 aritmatika
soal10(A, B) :- B is sin(A)*sin(A) + cos(A)*cos(A).












