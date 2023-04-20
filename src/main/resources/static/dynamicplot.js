var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
      type: 'line',
      data: {
        labels: [], // масив міток
        datasets: [{
          label: 'My dataset',
          data: [], // масив даних
          backgroundColor: 'rgba(255, 99, 132, 0.2)',
          borderColor: 'rgba(255, 99, 132, 1)',
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    });
  
    // Оновлюємо графік
    function updateChart(data) {
      myChart.data.labels.push(data.label);
      myChart.data.datasets.forEach((dataset) => {
        dataset.data.push(data.value);
      });
      if(myChart.data.labels.length>10){
        myChart.data.labels.shift();
        myChart.data.labels.shift();
        myChart.data.datasets.forEach((dataset) => {
            dataset.data.shift();
          });
      }
      myChart.update();
    }
  
    // Додавання нових даних кожні 5 секунд
    setInterval(() => {
      // Отримання нових даних з сервера
      fetch('/dataget')
        .then(response => response.json())
        .then(data => {
          // Оновлюємо графік з новими даними
          updateChart(data);
        });
    }, 2000);