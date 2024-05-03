document.addEventListener('DOMContentLoaded', function () {
    let intervalId;
    let elapsedSeconds = 0;

    function toggleInterval() {
      const toggleBtn = document.getElementById('toggleBtn');

      if (intervalId) {
        clearInterval(intervalId);
        intervalId = null;
        elapsedSeconds = 0;
        updateOutput();
        toggleBtn.textContent = 'Start';
        toggleBtn.classList.remove('stop');
      } else {
        intervalId = setInterval(updateOutput, 1000);
        toggleBtn.textContent = 'Stop';
        toggleBtn.classList.add('stop');
      }
    }

    function updateOutput() {
      const outputElement = document.getElementById('output');
      outputElement.textContent = `Elapsed Time: ${elapsedSeconds} seconds`;
      elapsedSeconds++;
    }

    document.getElementById('toggleBtn').addEventListener('click', toggleInterval);
  });