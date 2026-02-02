function sumArray(arr) {
  let sum = 0;
  for (let i = 0; i < arr.length; i++) {
    sum += arr[i];
  }
  return sum;
}
// What is the time complexity?
// Your answer: O(n)


function printPairs(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length; j++) {
      console.log(arr[i], arr[j]);
    }
  }
}
// What is the time complexity?
// Your answer: O(n^2)


function compareLists(listA, listB) {
  listA.forEach(a => {
    console.log(a);
  });
  
  listB.forEach(b => {
    console.log(b);
  });
}
// What is the time complexity?
// Your answer: O(a + b)


function processData(arr) {
  // First loop: O(n)
  arr.forEach(item => console.log(item));
  
  // Nested loops: O(n²)
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length; j++) {
      console.log(arr[i] + arr[j]);
    }
  }
}
// Initial complexity: O(n + n²)
// Simplified: O(n^2)


function createMatrix(n) {
  const matrix = [];
  
  for (let i = 0; i < n; i++) {
    matrix[i] = [];
    for (let j = 0; j < n; j++) {
      matrix[i][j] = i * j;
    }
  }
  
  return matrix;
}
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

// Current: O(n²) - finds if array has duplicates
function hasDuplicates(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[i] === arr[j]) {
        return true;
      }
    }
  }
  return false;
}


// Current: O(n²) - finds if array has duplicates
function hasDuplicates(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[i] === arr[j]) {
        return true;
      }
    }
  }
  return false;
}
// Optimize to O(n) using a Set or Object
// Optimize to O(n) using a Set or Object
function hasDuplicatesOptimized(arr) {
  const noDupe = new Set();
  for (let i = 0; i < arr.length; i++) {
      if (noDupe.has(arr[i])) {
          return true;
      }
      noDupe.add(arr[i]);
  }
  return false;
}