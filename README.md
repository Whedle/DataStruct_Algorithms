# DataStruct_Algorithms
Code, data, or information that students frequently ask about, or that I would like to be able to reference at a later date.

Note:
This repository mostly includes fairly common data structures and algorithms I have been using over the course of several years. The programming languages used include C, C#, Mathematica, and Java.
Beneathe you will find a listing of the contents of DataStruct_Algorithms. The code does not come with any guarantee or warranty and is shared strictly "as is." In some cases, parts of the framework required to fully 
implement the code are proprietary, and therefor will not be included within the public repository. Some code will not be usable and some of the programs' core features are not accessible (especially the AI, machine 
learning, and neural network programs). If you do not agree to accept all liability associated with the use of the code within this repository, do not access or use the code at all. The code, comments, and documentation 
in the repository are shared for STRICTLY EDUCATIONAL PURPOSES ONLY. Students should feel free to learn from the data structure and algorithm examples and documentation, but also recognize that failing to cite or reference 
the code will probably constitute an act of plagerism (depending upon your academic integrity policies).

## Getting Started
This repository can be separated into three major parts. Part I (Algorithms and Data Structures) includes explanations of computer science concepts, data structures, and algorithms, as well as associated pseudocode.
Part II (Code) includes actual code implemented in various languages. While all of the code currently listed in the table of contents has already been implemented, I am currently reformatting it and so either some
or much of the code may be unavailable for a short period of time. Nearly all of the code will be available, hopefully by 9/01/2017. Part III covers software engineering best practices and terminology. This should give
students (and professionals unfamiliar with the concepts) a good look into methods of efficient software engineering and design.
 
In order to successfully use this repository for learning core computer science and software engineering concepts, I highly recommend first reading the textbooks
	Ian Summerville. "Software Engineering". 10th ed. Read for an understanding of software engineering methods and taxonomy, including the Software Development Life Cycle.
	Michael T. Goodrich, Roberto Tamassia. "Data Structures and Algorithms in Java". 5th ed (or later). This textbook covers a vast deal of data struct and algorithm theory and implementation methods. I highly recommend it for any computer science or software engineering student.
	Richard L. Burden, Douglas J. Faires, Annette M. Burden. "Numerical Analysis". 10th. For students (or professionals) who wish to understand the core mathematical theory behind computer science and especially those who wish to use numerical methods and analysis, this textbook is really one of the best I have seen.
	and then using this repository as a reference.
These books were required reading for McNeese's Advanced Data Structures ("Data structures..."), Software Engineering I and II ("Software Engineering"), and Numerical Methods I and II ("Numerical Analysis"). If you are one of the students, I recommend reading the assigned text alongside any online documentation. Your professors will be able to tell the difference.

## Table of Contents

1. Algorithms and Data Structures
	- Data Structures
		- Linear Data Structures
			- Array List and Iterators
			- Queues
			- Stacks
		- Nonlinear Data Structures
			- Graphs
				- Taxonomy of Graphs
				- Trees
		- Maps
			- Maps
			- Hash Table Maps
		- Priority Queue
			- Priority Queues
			- Heaps
	- Numerical Methods and Analysis Algorithms
		- Solutions of Equations in one variable
			- Bisection Method
			- Fixed point Iteration
			- Newton's Method
		- Approximation
			- Interpolation and Polynomial Approximation
				- Neville's Method
				- Divided Differences
				- Cubic Spline Interpolation
				- Parametric Curves
			- Approximating Theory
				- Fast Fourier Transforms
			- Approximating Eigenvalues
				- Power Method
				- QR Algorithms
		- Differential Equations
			- Initial Value Problems for ODEs
				- Gaussian Quadrature
				- Euler's Method
				- Higher Order Taylor Methods
				- Runge Kutta Methods
			- Multistep Methods for Initial Value Problems for ODEs
				- Adams Bashforth and Adams Moulten
		- Matrix Algebra
			- Iterative Techniques
				- Jacobi Techniques
				- Gauss Siedel Iterative Technique
				- Successive Over Relaxation Method (SOR)
		- Nonlinear Systems of Equations
			- Numerical Solutions
				- Newton's Method
	- EulerTours
	
2. Code

	- Java
		- ArrayList_Iterator
			- DNode
			- ElementIterator
			- NodePositionList
			- Position
			- PositionList
		- BinaryTree
			- ArrayListCompleteBinaryTree
			- BinaryTree
			- BTNode
			- BTPosition
			- CompleteBinaryTree
			- LinkedBinaryTree
			- Tree
		- Exceptions
			- BounadryViolationException
			- EmptyListException
			- EmptyPriorityQueueException
			- EmptyTreeException
			- FullStackException
			- InvalidEntryException
			- InvalidKeyException
			- InvalidPositionException
			- NonEmptyTreeException
			- NoSuchElementException
		- Maps
			- Entry
			- HashTableMap
			- Map
		- PriorityQueue
			- HeapPriorityQueue
			- PriorityQueue
			- PriorityQueueAdaptable
			- PriorityQueueComparator
			- PriorityQueueEntry
			- PriorityQueueSortedList
			- PriorityQueueSortedListAdaptable
		- Queue_Stack
			- Node
			- Queue
			- QueueUsingStack
			- QueueUsingList
			- Stack
			- StackUsingList
		- Sorting
			- SortingAlgorithmsMain
			- Sorter
			
	- C#
		- Plant Controller
			- PlantController
			- SpeciesController
		- StateMachineHarvest
			- Bias
			- ClusterBias
			- HarvestState
			- IdleState
			- InteractState
			- Inventroy
			- NeuralNet
			- ObjectiveControl
			- ReturnState
			- SearchState
			- StateControllerHarvest
			- UserIState
		- WeatherControl
			- AutoIntensity
			- MeterologicalController
			- Weather
			
	- C
		- RoundRobinScheduling
		
	- Mathematica
		- Solutions of Equations in one variable
			- OneVar_BisectionMethod
			- OneVar_FixedPointIteration
			- OneVar_NewtonsMethod
		- Approximation using Interpolation and Polynomials
			- InterPolyApprox_NevillesMethod
			- InterPolyApprox_DividedDifferences
			- InterPolyApprox_CubicSpline
		- Initial Value Problems for Ordinary Differential Equations
			- IVPODE_GaussianQuadrature
			- IVPODE_EulersMethod
			- IVPODE_HigherORderTaylorMethod
			- IVPODE_RungeKuttaMethod
			- IVPODE_AdamsBash2andMoulten3
		- Matrix Algebra Iterative Techniques
			- MatAlg_JacobiMethod
			- MatAlg_GaussSiedelIterative
			- MatAlg_SOR
		- Approximation of Eigenvalues
			- EigApprox_PowerMethod
			- EigenApprox_QRMETHOD
		- Numerical Solutions to nonlinear Systems of Equations
			- NonLinearSys_NewtonsMethod
			
3. Software Engineering
	- The Software Development Life Cycle
	- Core Software Development Activities
	- Agile Methods
	- Requirements Engineering
		- Function Requirements
		- Nonfunctional Requirements
	- Design
	- Testing
	- Dependable Systems
		- Reliability
		- Availability
		- Safety
		- Security
		- Resilience
	- Software Reuse
	- Component Based Software Engineering
	- Distributed Software Engineering
	- Service Oriented Software Engineering
	- Systems Engineering
	- Project Management
