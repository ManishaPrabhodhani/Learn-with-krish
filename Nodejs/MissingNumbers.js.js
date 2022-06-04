var array = [21,25,29,28,22,24,27,26,30],
arr = array.sort()


count = arr[arr.length-1]
missingNumber = []

for (let i = arr[0]; i <= count; i++) {
  if (arr.indexOf(i) === -1) {
    missingNumber.push(i)
  }
}

//console.log(array)
console.log(missingNumber)